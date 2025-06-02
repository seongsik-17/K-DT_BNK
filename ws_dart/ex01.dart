void main() {
  //한줄 주석
  /*
   * 여러줄 주석
   * ㅋ.ㅋ
   * */

  //   final String name = '블랙핑크';
  //   print(name);
  //   //name = 'BTS';

  //   const String name2 = 'BTS';
  //   print(name2);

  //final은 런타임, const는 빌드타임 상수임

  //final DateTime now = DateTime.now(); //실행하는 시점에 값을 알수있음
  //const DateTime now = DateTime.now(); //번역될때 값을 알고 있어야함(고급언어 -> 저급언어)

  List<String> blackPinkList = ['리사', '지수', '제니', '로제'];

  print(blackPinkList);
  print(blackPinkList[3]);
  print(blackPinkList.length);
  blackPinkList[3] = '박나래';
  print(blackPinkList);
  blackPinkList.add('박나래');
  print(blackPinkList);

  final newList = blackPinkList.where((name) => name == '리사' || name == '지수');
  //where() => List에 있는 값들을 순서대로 순회하면서 특정 조건에 맞는 값만 필터링 하는데 사용됨
  //매게변수에 함수를 입력해야하며, 입력된 함수는 기존 값을 하나씩 매개변수로 입력받는다.
  //각 값별로 true를 반환하면 값을 유지하고, flase를 반환하면 값을 버린다.
  // 순회가 끝나면 유지된 값들을 기반으로 이터러블(Iterable)이 반환된다.

  //map(): List에 있는 값들을 순서대로 순회하면서 값을 변경한다.
  //매게변수 함수를 입력해야하며, 입력된 함수는 기존 값을 하나씩 매개변수로 입력받는다.
  //반환하는 값이 현재값을 대체한다.
  //순회가 끝나면 이터러블을 반환함.

  print(newList.toList());

  final newBlackPink = blackPinkList.map((name) => '블랙핑크 $name');

  print(newBlackPink);
}
