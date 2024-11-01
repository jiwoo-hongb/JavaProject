# Java Calculator Project

![Calculator Screenshot]([path/to/screenshot.png](https://github.com/user-attachments/assets/85a6a4e6-6eb6-4347-beb2-0c08d92eafec)) <!-- Use a screenshot of your calculator here -->

## 프로젝트 개요
이 프로젝트는 Java의 `Swing`을 사용하여 개발한 기본적인 계산기 프로그램입니다. 사용자 친화적인 GUI를 제공하며, 덧셈, 뺄셈, 곱셈, 나눗셈과 같은 일반적인 계산 기능을 포함하고 있습니다. **둥근 버튼 디자인**과 **모던한 인터페이스**로 사용자 경험을 향상시켰습니다.

## 주요 기능
- **기본 연산**: 덧셈, 뺄셈, 곱셈, 나눗셈
- **부호 변경**: `±` 버튼을 사용하여 입력된 숫자의 부호를 변경
- **백분율 계산**: `%` 버튼을 사용한 백분율 연산
- **Clear 기능**: `C` 버튼을 사용해 입력 초기화
- **실시간 결과 확인**: 이퀄(=) 버튼을 눌러 계산 결과 즉시 출력

## 프로젝트 구조
src/ │ ├── gui/ │ ├── Main_Gui.java // 계산기의 메인 GUI 클래스 │ ├── RoundBtn.java // 둥근 버튼을 구현한 클래스 │ ├── Design_forGui.java // 계산기의 디자인 및 스타일 설정 클래스 │ ├── function/ │ └── ButtonAction.java // 버튼 클릭 이벤트를 처리하는 클래스 │ └── README.md // 프로젝트 설명 파일


## 클래스 설명
### `Main_Gui.java`
- 계산기의 메인 GUI 클래스입니다.
- `JTextField`를 사용하여 입력값을 표시하며, 버튼 패널은 `GridBagLayout`을 통해 구성됩니다.
- **둥근 버튼 스타일**이 적용되며, 각 버튼은 `ButtonAction` 클래스를 통해 이벤트를 처리합니다.

### `RoundBtn.java`
- `JButton`을 확장하여 둥근 모양의 버튼을 구현한 클래스입니다.
- 사용자 인터페이스의 미적 감각을 향상시키기 위해 디자인되었습니다.

### `Design_forGui.java`
- 계산기의 **디자인 및 스타일**을 관리하는 클래스입니다.
- **배경색**, **버튼 색상**, **폰트 스타일** 등을 설정하여 일관된 사용자 인터페이스를 제공합니다.

### `ButtonAction.java`
- 계산기 버튼의 클릭 이벤트를 처리하는 클래스입니다.
- `ActionListener`를 구현하여 사용자의 입력을 캡처하고, 계산 결과를 `inputSpace`에 출력합니다.

