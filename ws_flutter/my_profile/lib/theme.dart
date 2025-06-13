import 'package:flutter/material.dart';
const MaterialColor primaryColor = MaterialColor(
  0xFF0A192F, // 기준색: 짙은 네이비
  <int, Color>{
    50: Color(0xFFE3EAF2),
    100: Color(0xFFB9C9DB),
    200: Color(0xFF8CA6C3),
    300: Color(0xFF5F83AB),
    400: Color(0xFF3D6899),
    500: Color(0xFF1C4D87), // 기준색보다 살짝 연한 블루
    600: Color(0xFF18467F),
    700: Color(0xFF133C74),
    800: Color(0xFF0F336A),
    900: Color(0xFF081F58),
  },
);


ThemeData theme() {
  return ThemeData(
    primarySwatch: primaryColor,
    appBarTheme: AppBarTheme(
      iconTheme: IconThemeData(color: Colors.tealAccent[100]),
    ),
  );
}