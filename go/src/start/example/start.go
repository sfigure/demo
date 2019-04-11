package main

import (
	"github.com/go-martini/martini"
	"github.com/go-redis/redis"
	"encoding/json"
	"net/http"
	"github.com/satori/go.uuid"
	"strconv"
	"fmt"
)

type User struct {
	Username string
	Password string
}

type UserList struct {
	UUID string  `json:"uuid"`
	Username string  `json:"username"`
	Avatar string  `json:"avatar"`
	Note string  `json:"note"`
	LastContext string `json:"last_context"`
}

func genToken() {

}

type Response struct {
	Code int     `json:"code"`
	Body *string `json:"body"`
	Msg  string  `json:"msg"`
}

type ResponseV1 struct {
	Code int    `json:"code"`
	Body string `json:"body"`
	Msg  string `json:"msg"`
}

type ResponseList struct {
	Code int    `json:"code"`
	Body []UserList `json:"body"`
	Msg  string `json:"msg"`
}

func successList(body []UserList) (string) {
	rs, _ := json.Marshal(ResponseList{Code: 0, Body: body, Msg: "success"})
	return string(rs);
}

func successV1(body string) (string) {
	rs, _ := json.Marshal(ResponseV1{Code: 0, Body: body, Msg: "success"})
	return string(rs);
}

func successV0() (string) {
	rs, _ := json.Marshal(ResponseV1{Code: 0, Body: "", Msg: "success"})
	return string(rs);
}

func success(body *string) (string) {
	rs, _ := json.Marshal(Response{Code: 0, Body: body, Msg: "success"})
	return string(rs);
}

func fail(msg string) (string) {
	rs, _ := json.Marshal(ResponseV1{Code: 1, Body: "", Msg: msg})
	return string(rs);
}

func main() {
	kv := redis.NewClient(&redis.Options{
		Addr:     "localhost:6379",
		Password: "",
		DB:       0,
	})

	api := martini.Classic()
	api.Map(&kv);
	api.Group("/api/v1", func(r martini.Router) {
		api.Get("/test", func() string {
			a := "test";
			return success(&a);
		})
		//登录
		api.Get("/login", func(c martini.Context, req *http.Request) string {
			if kv.Exists("user@" + req.FormValue("username")).Val() > 0 {
				password := kv.Get("user@" + req.FormValue("username"));
				if req.FormValue(	"password") == password.Val() {
					token := uuid.NewV4().String();
					kv.Set("token@"+token, req.FormValue("username"), 0);
					return successV1(token)
				} else {
					return fail("密码错误");
				}
			} else {
				return fail("用户不存在");
			}
		})
		//注册
		api.Get("/signup", func(c martini.Context, req *http.Request) string {
			if kv.Exists("user@" + req.FormValue("username")).Val() == 0 {
				kv.Set("user@"+req.FormValue("username"), req.FormValue("password"), 0)
				token := uuid.NewV4().String();
				//用户名称
				kv.HSet("userInfo@"+req.FormValue("username"),"name","userInfo@"+req.FormValue("username"))
				//用户uuid
				kv.HSet("userInfo@"+req.FormValue("username"),"uuit",token)
				//好友数量
				kv.HSet("userInfo@"+req.FormValue("username"),"userListCount",0)

				kv.Set("token@"+token, req.FormValue("username"), 0);
				return successV1(token)
			} else {
				return fail("用户已经注册");
			}
		})
		//退出登录
		api.Get("/logout", func(c martini.Context, req *http.Request) string {
			if kv.Exists("token@" + req.FormValue("token")).Val() != 0 {
				token := "token@" + req.FormValue("token");
				kv.Del(token);
			}
			return successV0()
		})
		//获取用户信息
		api.Get("/info", func(c martini.Context, req *http.Request) string {
			if kv.Exists("token@" + req.FormValue("token")).Val() != 0 {
				token := "token@" + req.FormValue("token");
				return successV1(kv.Get(token).Val())
			} else {
				return fail("token error")
			}
		})
		//好友列表
		api.Get("/list", func(c martini.Context, req *http.Request) string {
			if kv.Exists("token@" + req.FormValue("token")).Val() != 0 {
				token := "token@" + req.FormValue("token");
				user:=kv.Get(token).Val();
				userListCount:=kv.HGet("userInfo@"+user,"userListCount").Val()
				//用户信息
				userListCountInt,_:=strconv.ParseInt(userListCount,10,64)
				userlist := make([]UserList,userListCountInt);
				return successList(userlist);
			} else {
				return fail("token error")
			}
		})
		//添加好友
		api.Get("/add_friend", func(c martini.Context, req *http.Request) string 		{
			if kv.Exists("token@" + req.FormValue("token")).Val() != 0 {
				token := "token@" + req.FormValue("token");
				user:=kv.Get(token).Val();
				fmt.Print(user);
				targetFriendName:=req.FormValue("target_user")
				userlistKey:="userList@"+user
				kv.HSet(userlistKey,targetFriendName,"admin")
				if kv.HExists(userlistKey,targetFriendName).Val() {
					fmt.Println("用户已经存在")
					userlist1:=kv.HGetAll(userlistKey).Val();
					userlistLens:=userlist1["admin"];
					fmt.Println(userlistLens)
					userListCount:=kv.HGet("userInfo@"+user,"userListCount").Val()
					userListCountInt,_:=strconv.ParseInt(userListCount,10,64)
					kv.HSet("userInfo@"+user,"userListCount",userListCountInt).Val()
					userlist := make([]UserList,userListCountInt);
					return successList(userlist);
				}else {
					fmt.Println("用户不存在")
					userListCount:=kv.HGet("userInfo@"+user,"userListCount").Val()
					userListCountInt,_:=strconv.ParseInt(userListCount,10,64)
					kv.HSet("userInfo@"+user,"userListCount",userListCountInt+1).Val()
					userlist := make([]UserList,userListCountInt+1);
					return successList(userlist);
				}


			} else {
				return fail("token error")
			}
		})
	})

	api.Run()
}
