import 'package:flutter/material.dart';

void main(){
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'BnK Card',
      home: MainPage(),
    );
  }
}

class MainPage extends StatelessWidget {
  const MainPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('CardSalse'),
      ),
      body: Column(
        children: [
          Image.asset('cardImage.png',width: 100, height: 100,),
          Text('카드발급 TOP100 리스트',style: TextStyle(fontSize: 20,fontWeight: FontWeight.bold),),
          SizedBox(height: 10,),
          Padding(
            padding: const EdgeInsets.all(25.0),
            child: Container(
              height: 200,
              width: 500,
              color: Colors.brown[200],
              child: Padding(
                padding: const EdgeInsets.all(20.0),
                child: Row(
                  children: [
                    Text('순위',style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),),
                    SizedBox(width: 10,),
                    Text('☝'),
                    SizedBox(width: 10,),
                    Image.asset('cardImage.png',width: 100, height: 100,),
                    Column(
                      mainAxisAlignment: MainAxisAlignment.center,
                     children: [
                       Row(
                         children: [
                           Text('이벤트 내용'),
                         ],
                       ),
                       Row(
                         children: [
                           Text('카드이름')
                         ],
                       ),
                       Row(
                         children: [
                           Text('카드사')
                         ],
                       )
                     ],
                    )

                  ],
                ),
              ),

            ),
          )
        ],
      ),
    );
  }
}

