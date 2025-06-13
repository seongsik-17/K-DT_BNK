import 'package:flutter/material.dart';

class Profileheader extends StatelessWidget {
  const Profileheader({super.key});

  @override
  Widget build(BuildContext context) {
    return Column(children: [SizedBox(width: 20),
    _buildHeaderAvatar(),
     SizedBox(width: 20),
     _buildHeaderProfile(),
     ]);
  }

  Widget _buildHeaderAvatar() {
    return SizedBox(
      width: 200,
      height: 200,
      child: CircleAvatar(
        backgroundImage: AssetImage("assets/증명사진.jpg")
        ),
    );
  }

  Widget _buildHeaderProfile() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          "Moon Seongsik",
          style: TextStyle(fontSize: 25, 
          fontWeight: FontWeight.w700),
        ),
        Text("웹 개발 초보운전",
        style: TextStyle(
          fontSize: 20,
          fontWeight: FontWeight.bold
        ),),
        Text("이것은 백인가 프론트인가...",
        style: TextStyle(
          fontSize: 15,
        ),),
      ],
    );
  }
}
