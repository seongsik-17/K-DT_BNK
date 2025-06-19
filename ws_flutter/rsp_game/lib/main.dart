import 'dart:math';

import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'RSP Game',
      home: const Rsp_game(title: 'Rsp_game'),
    );
  }
}

class Rsp_game extends StatefulWidget {
  const Rsp_game({super.key, required this.title});
  final String title;
  @override
  State<Rsp_game> createState() => _Rsp_gameState();
}

class _Rsp_gameState extends State<Rsp_game> {
  int cpu = 0;
  int player = 0;
  int win = 0;
  int draw = 0;
  int lose = 0;
  String user_result = '결과는?';
  String cpu_result = '결과는?';
  //가위(0), 바위(1), 보(2)
  //
  void _playGame() {
    setState(() {
      cpu = Random().nextInt(3);
      player = Random().nextInt(3);
      //win case
      if ((player == 0 && cpu == 2) ||
          (player == 1 && cpu == 0) ||
          (player == 2 && cpu == 1)) {
        user_result = '이겼습니다!';
        cpu_result = '졌습니다!';
        win++;
         print('컴퓨터: ${cpu}');
        print('사용자: ${player}');
        //draw case
      } else if (cpu == player) {
        user_result = '비겼습니다!';
        cpu_result = '비겼습니다!';
        draw++;
         print('컴퓨터: ${cpu}');
        print('사용자: ${player}');
        //lose case
      } else {
        user_result = '졌습니다!';
        cpu_result = '이겼습니다!';
        lose++;
        print('컴퓨터: ${cpu}');
        print('사용자: ${player}');
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('RSP Game')),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text('가위바위보 게임', style: TextStyle(fontSize: 40)),
            SizedBox(height: 20),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              children: [Text('CPU'), Text('USER')],
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              children: [
                Text(
                  '${user_result}',
                  style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
                ),
                Text(
                  '${cpu_result}',
                  style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
                ),
              ],
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              children: [
                Image.asset('${cpu}.jpg', height: 200, width: 200),
                Image.asset('${player}.jpg', height: 200, width: 200),
              ],
            ),
            Text('승·무·패'),
            Text('${win} | ${draw} | ${lose}'),
          ],
        ),
      ),

      floatingActionButton: Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          FloatingActionButton.large(
            onPressed: _playGame,
            tooltip: '게임시작',
            child: Text(
              '게임시작',
              style: TextStyle(fontSize: 25, fontWeight: FontWeight.bold),
            ),
          ),
        ],
      ),
    );
  }
}
