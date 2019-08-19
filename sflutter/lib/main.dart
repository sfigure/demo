import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() => runApp(new MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: 'Flutter Demo',
      theme: new ThemeData(
        primarySwatch: Colors.red,
      ),
      home: new MyHomePage(title: '这是标11题'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);

  final String title;

  @override
  _MyHomePageState createState() => new _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final String title1 = "标题11";
  final List<String> items = new List();

  @override
  void initState() {
    setState(() {
      items.add("a");
      items.add("b");
    });
    super.initState();
    debugPrint(">>>initState<<<");
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
        body: Column(
      crossAxisAlignment: CrossAxisAlignment.center,
      children: <Widget>[
        Row(children: <Widget>[
          Container(
              color: const Color(0xFF00FF00),
              width: 48.0,
              height: 48.0,
              child: Text("1")),
          Padding(
            padding: EdgeInsets.only(
                left: 10.0, top: 20.0, right: 30.0, bottom: 40.0),
            child: Text("2"),
          ),
          Center(
            child: Text("3"),
          ),
          SizedBox(
            width: 20.0,
            height: 30.0,
            child: const Card(child: Text('4')),
          ),
          Expanded(child: Text("5"))
        ]),
        Container(
          height: 50.0,
          child:ListView.builder(
          scrollDirection:Axis.horizontal,
          itemExtent: 80.0,
          itemBuilder: (BuildContext context, int index) {
            return Text('nav $index',textAlign: TextAlign.center,);
          },
        ),
        ),
    Expanded(child:ListView.builder(
    itemExtent: 80.0,
    itemBuilder: (BuildContext context, int index) {
        return Text('record $index',textAlign: TextAlign.left,);
    },
    ))
      ],
    ));
  }
}
