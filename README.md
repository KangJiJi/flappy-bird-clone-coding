# Flappy-bird-clone-coding

![flappyBird](https://user-images.githubusercontent.com/22635168/89732418-ce048980-da89-11ea-85d9-2c9109bc9917.png)

# Description

`객체지향프로그래밍` 수업 시간 개인 프로젝트로 제출한 `Java`와 `JavaFx`를 `Flappy bird` 게임 `clone coding` 프로젝트다. 이 프로젝트만의 특징으로는 미사일 장애물이 추가됐다.

여러 기능의 구현보다는 객체지향적 사고와 유지 보수 가능한 코드를 만드는 것에 더 중점을 두고 프로젝트를 진행했다. `View`와 `Logic`을 분리했고, 상속과 다형성을 이용해 객체지향 패러다임에 충실하게 설계를 했다. 교수님께 좋은 평가를 받을 수 있는 프로젝트였다.

# Design document

## Use case diagram

![Use case](https://user-images.githubusercontent.com/22635168/89732493-3a7f8880-da8a-11ea-9188-616ecb80e5dc.png)

사용자가 행할 수 있는 행위들이다. 게임 시작, 게임 재시작, 게임 종료가 있다.

## Sequence diagram

![Squence diagram](https://user-images.githubusercontent.com/22635168/89732492-381d2e80-da8a-11ea-8914-4c677e85a5be.png)

`Routing`을 위해 세 가지 `Pane`을 사용하였다. 첫 페이지가 되는 `MainPane`, 게임 플레이 화면인 `GamePane` 그리고 Game over 시 나오는 `ResultPane`이 있다. 사용자는 게임을 시작 후 게임을 하다가 장애물에 부딪치게 되면 점수와 함께 `ResultPane`이 나오게 된다. `ResultPane`에서 종료할 것인지 다시 게임을 할선 것인지 택할 수 있다.

## Class diagram

![Class diagram](https://user-images.githubusercontent.com/22635168/89732494-3ce1e280-da8a-11ea-83a5-0abc9b9754c1.png)

최대한 `객체지향 패러다임`에 충실하게 상속과 다형성을 이용해 설계를 했다. 추상 클래스를 통해 `View`와 `Logic`을 분리하고 적적한 `캡슐화`와 `Marker interface`를 이용해 잠재적 `fault`를 예방할 수 있다. 추후에 여러 캐릭터나 장애물을 추가할 수 있다.

# Demonstration

![flappy bird play](https://user-images.githubusercontent.com/22635168/89732498-40756980-da8a-11ea-9661-2f449adc8b8a.gif)
