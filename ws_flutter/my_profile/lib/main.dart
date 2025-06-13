import 'package:flutter/material.dart';
import 'package:my_profile/components/ProfileContent.dart';
import 'package:my_profile/components/ProfileCountInfo.dart';
import 'package:my_profile/components/profileHeader.dart';
import 'package:my_profile/theme.dart';

void main() {
  runApp(const MyProfile());
}

class MyProfile extends StatelessWidget {
  const MyProfile({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: theme(),
      home: ProfilePage(),
    );
  }
}

class ProfilePage extends StatelessWidget {
  const ProfilePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: _buildProfileAppBar(),
      body: Column(
        children: [
          SizedBox(height: 20),
          Profileheader(),
          SizedBox(height: 20),
          Profilecountinfo(),
          SizedBox(height: 20),
          Profilecontent(),
          SizedBox(height: 40, width: 40,),
        ],
      ),
    );
  }

  AppBar _buildProfileAppBar(){
    return AppBar(
      leading: Icon(Icons.add_box_sharp),
      title: Text("Profile"),
      centerTitle: true,
    );
  }
}
