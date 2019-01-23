import 'package:flutter/material.dart';

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
      home: new MyHomePage(title: '这是标题'),
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
  int _counter = 0;
  final String title1="标题11";
  void _incrementCounter() {
    setState(() {
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    //
    // The Flutter framework has been optimized to make rerunning build methods
    // fast, so that you can just rebuild anything that needs updating rather
    // than having to individually change instances of widgets.
    return new Scaffold(
      appBar: new AppBar(
        // Here we take the value from the MyHomePage object that was created by
        // the App.build method, and use it to set our appbar title.
        title: new Text("标题11"),
      ),
      body: new Center(
        // Center is a layout widget. It takes a single child and positions it
        // in the middle of the parent.
        child: Column(
          children: <Widget>[
            new Column(

              mainAxisAlignment: MainAxisAlignment.start,
              children: <Widget>[
                new Text(
                  '$_counter',
                  style: Theme.of(context).textTheme.display1,
                ),
                new Text(
                  title1
                ),
                new Text(
                  '按钮点击次数:',
                ),
              ],
            ),
            new Column(

              mainAxisAlignment: MainAxisAlignment.start,
              children: <Widget>[
                new Text(
                  '$_counter',
                  style: Theme.of(context).textTheme.display1,
                ),
                new Text(
                    title1
                ),
                new Text(
                  '按钮点击次数:',
                ),
              ],
            ),
          ],
        ),

      ),
      bottomNavigationBar:new ButtonBar(children: <Widget>[
        Row(
          children: <Widget>[
            new Text("111"),
            new Text("111"),
            new Text("111"),
          ],
        ),
      ],),
      floatingActionButton: new FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: new Icon(Icons.add),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
