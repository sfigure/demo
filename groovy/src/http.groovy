@Grapes(
        @Grab(group = 'com.squareup.okhttp3', module = 'okhttp', version = '3.14.1')
)
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.MultipartBody

def client = new OkHttpClient();

def fileBody = RequestBody.create(MediaType.parse("application/apk"), new File("C:\\Users\\Administrator\\Downloads\\shellmanager-release-v1.0.8-tencent.apk"))

def requestBody = new MultipartBody.Builder()
        .setType(MultipartBody.FORM)
        .addFormDataPart("file", "shellmanager-release-v1.0.8-tencent.apk", fileBody)
        .build();
//上传到ops后台
def request = new Request.Builder()
        .url('http://ops-dev.devcloud.chupinxiu.com/version/upload')
        .post(requestBody)
        .build();
//执行
try {
    def response = client.newCall(request).execute()
    println(response.body().string())
} catch (e) {
    e.printStackTrace()
}
