import 'package:flutter/material.dart';


void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    //위젯이 어디에 위치해야하는지 지정해줌
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title}); //title이 필수적으로 필요

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

List _list = ['1번 자료', '2번 자료', '3번 자료', '4번 자료', '5번 자료'];
List imageList = ['assets/day.png', 'assets/nights.png'];

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0; //여기에 변수를 선언하면 이 값을 바꾸겠다는 의미
  //setState를 통해서 위에 선언된 변수를 변경하겠다는 의미
  int _i = 0;
  int _imgIndex = 0;

  void _incrementCounter() {
    setState(() {
      //상태를 변경할 경우 setState를 통해 변경함
      // This call to setState tells the Flutter framework that something has
      // changed in this State, which causes it to rerun the build method below
      // so that the display can reflect the updated values. If we changed
      // _counter without calling setState(), then the build method would not be
      // called again, and so nothing would appear to happen.
      _counter++;
    });
  }

  void _decrementCounter() {
    setState(() {
      _counter--;
    });
  }

  void _changeindex() {
    setState(() {
      if (_i >= _list.length - 1) {
        _i = 0;
      } else {
        _i++;
      }
    });
  }

  void _changeImage() {
    setState(() {
      if (_imgIndex >= imageList.length - 1) {
        _imgIndex = 0;
      } else {
        _imgIndex++;
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const Text('You have pushed the button this many times:'),
            Text(
              '$_counter',
              style: Theme.of(context).textTheme.headlineMedium,
            ),
            Text(
              '리스트 자료: ${_list[_i]}',
              style: TextStyle(fontWeight: FontWeight.bold),
            ),
            Text('현재 인덱스: $_i'),
            SizedBox(height: 30,),
            Image.asset('${imageList[_imgIndex]}', height: 200, width: 200),
          ],
        ),
      ),
      floatingActionButton: Row(
        mainAxisAlignment: MainAxisAlignment.end,

        children: [
          const SizedBox(width: 16),
          FloatingActionButton(
            onPressed: _incrementCounter,
            tooltip: 'Increment', //말풍선 생성
            child: const Icon(Icons.add), //+모양 아이콘 생성
          ),
          SizedBox(width: 10),
          FloatingActionButton(
            onPressed: _decrementCounter,
            tooltip: 'Decrement',
            child: const Icon(Icons.remove),
          ),
          SizedBox(width: 10),
          FloatingActionButton(
            onPressed: _changeindex,
            tooltip: 'nextIndex',
            child: const Icon(Icons.skip_next),
          ),
          SizedBox(width: 20),
          FloatingActionButton(
            onPressed: _changeImage,
            tooltip: 'nextImage',
            child: const Icon(Icons.image),
          ),
        ],
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
