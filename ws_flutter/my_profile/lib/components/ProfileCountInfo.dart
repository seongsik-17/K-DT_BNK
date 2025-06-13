import 'package:flutter/material.dart';

class Profilecountinfo extends StatelessWidget {
  const Profilecountinfo({super.key});

  @override
  Widget build(BuildContext context) {
    return Row(
       mainAxisAlignment: MainAxisAlignment.spaceAround,
      children: [
        _buildInfo("상태", "구직중"),
        _buildLine(),
        _buildInfo("전공", "🛠임베디드IT",),
        _buildLine(),
        _buildInfo("스킬 보유현황", "10+"),
      ],
    );
  }

  Widget _buildInfo(String count, String title) {
    return Column(
      children: [
        Text(
          count,
          style: TextStyle(fontSize: 15),
        ),
        SizedBox(height: 2),
        Text(
          title,
          style: TextStyle(fontSize: 20),
        ),
      ],
    );
  }

  Widget _buildLine() {
    return Container(width: 2, height: 60, color: Colors.deepOrangeAccent);
  }
}