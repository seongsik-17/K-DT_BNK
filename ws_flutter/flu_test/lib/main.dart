import 'package:flu_test/test.dart';
import 'package:flutter/material.dart';
void main(){
  runApp(MyApp2());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});
//안드로이드 디자인(home), Scaffold: 머릿글 바닥글 작성용(appBar, body)
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: Text("TestWidget"),
        ),
        body: Column(
          children: [
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              children: [
                Container(
                  width: 100,
                  height: 100,
                  color: Colors.red,
                  child: Text("text1"),
                ),
                Container(
                  width: 100,
                  height: 100,
                  color: Colors.green,
                  child: Text("text2"),
                ),
                Container(
                  width: 100,
                  height: 100,
                  color: Colors.blue,
                  child: Text("text3")
                ),
              ],
            ),
            Center(
              child: Image.asset('assets/bag.jpeg'),
            ),
            SizedBox(height: 50,),
            Expanded(
              child: ListView(
                children: [
                  ListTile(
                    leading: Icon(Icons.people),//앞쪽 아이콘
                    title: Text('item1',style: TextStyle(fontWeight: FontWeight.bold)),
                    subtitle: Text('seutitle1'),
                    trailing: Icon(Icons.forest),//뒤쪽 아이콘
                  ),
                  ListTile(
                    leading: Icon(Icons.people),
                    title: Text('item2',style: TextStyle(fontWeight: FontWeight.bold)),
                    subtitle: Text('seutitle2'),
                    trailing: Icon(Icons.forest),
                  ),
                  ListTile(
                    leading: Icon(Icons.people),
                    title: Text('item3',style: TextStyle(fontWeight: FontWeight.bold)),
                    subtitle: Text('seutitle3'),
                    trailing: Icon(Icons.forest),
                    onTap: (){//클릭 가능하게 만들어줌
                      print('item3 Checked');//콘솔에 출력
                    },
                  ),
                  
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}



