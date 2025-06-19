
import 'package:flutter/material.dart';



class MyApp2 extends StatelessWidget {
  const MyApp2({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: Text('testTitle',),
          centerTitle: true, 
        ),
        body: Column(
          children: [
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              children: [
                Container(
                  width: 100,
                  height: 100,
                  color: Colors.red[600],
                  alignment: Alignment.center,
                  child: Text("text1", style: TextStyle(fontWeight: FontWeight.bold),),
                ),
                Container(
                  width: 100,
                  height: 100,
                  color: Colors.lightGreen,
                  alignment: Alignment.center,
                  child: Text("text2", style: TextStyle(fontWeight: FontWeight.bold),),
                ),
                Container(
                  width: 100,
                  height: 100,
                  color: Colors.lightBlue[600],
                  alignment: Alignment.center,
                  child: Text("text3", style: TextStyle(fontWeight: FontWeight.bold),),
                ),
              ],
            ),
            Container(
              width: 300,
              height: 300,
              child: Image.asset('assets/bag.jpeg'),
            ),
            Expanded(
              child: ListView(
                children: [
                  ListTile(
                    leading: Icon(Icons.people),//앞쪽 아이콘
                    title: Text("버튼1"),
                    subtitle: Text("부가설명...."),
                    onTap: () {
                      print('');
                    },
                  ),
                  ListTile(
                    leading: Icon(Icons.people),//앞쪽 아이콘
                    title: Text("버튼2"),
                    subtitle: Text("부가설명...."),
                     onTap: () {
                      print('');
                    },
                  ),
                  ListTile(
                    leading: Icon(Icons.people),//앞쪽 아이콘
                    title: Text("버튼3"),
                    subtitle: Text("부가설명...."),
                     onTap: () {
                      print('');
                    },
                  )
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}