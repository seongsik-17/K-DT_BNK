
import 'User.dart';

mixin Logger{
  void log(String msg){
    print('Log: $msg');
  }
}

class UserManager with Logger {

  List<User>list = [];

  void addUser(User user){
    log("**사용자 추가**");
    list.add(user);
    log('삽입된 데이터 이름: ${user.name} 이메일: ${user.email} 나이: ${user.age}');
  }

  void listUser(){
    log("**전체 사용자 조회**");
    for(User m in list){
      log('이름: ${m.name} 이메일: ${m.email} 나이: ${m.age}');
    }
  }

  void findByEmail(String email){
     log("**개별 사용자 조회**");
    for(User m in list){
      if(m.email == email){
        log('이름: ${m.name} 이메일: ${m.email} 나이: ${m.age}');
        return;
      }
    }
    log('해당하는 사용자가 없습니다!');
  }

  void deleteUser(String email){
     log("**사용자 삭제**");
     for(User m in list){
      if(m.email == email){
        log('이름: ${m.name} 이메일: ${m.email} 나이: ${m.age} 가 삭제됩니다...' );
        list.remove(m);
        return;
      }
    }
    log('해당하는 사용자가 없습니다!');
  }

}
  void main(){
    UserManager userManager = UserManager();
    
    userManager.addUser(User('Alice','alice@example.com',25));
    userManager.addUser(User('Bob','bob@example.com',17));
    userManager.addUser(User('David','david@example.com',33));
    userManager.addUser(User('Emma','emma@example.com',29));

    userManager.listUser();
    userManager.findByEmail('bob@example.com');
    userManager.deleteUser('bob@example.com');

    userManager.listUser();

  }
