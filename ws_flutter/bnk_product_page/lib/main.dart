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
      title: 'BNK Bank',

      home: const HomePage(),
    );
  }
}

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Image.asset('Bnk.png'),),
      body: Column(
        children: [
          Row(
            children: [
              Container(
                width: 200,
                height: 200,
                child: ClipRRect(
                  borderRadius: BorderRadius.circular(20.0), // <- 둥글게
                  child: Image.asset(
                    'assets/Bnk-logo.png',
                    fit: BoxFit.cover, 
                  ),
                ),
              ),
              Container(
                width: 200,
                height: 200,
                child: ClipRRect(
                  borderRadius: BorderRadius.circular(20.0), // <- 둥글게
                  child: Image.asset(
                    'assets/giants_logo.png',
                    fit: BoxFit.cover, 
                  ),
                ),
              )
            ],
          ),
          Row(
            
          )
        ],
      ),
    );
  }
}
