class User{
  final String name;
  final int age;
  final String message;

  User({required this.name, required this.age,  required this.message});

  factory User.fromJson(Map<String, dynamic> json){
    return User(
      name: json['name'],
      age: json['age'],
      message: json['message'],
    );
  }
}