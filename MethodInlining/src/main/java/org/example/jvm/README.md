VM Option 을 수정해보면서 Method Inlining이 어떤 효과를 가져오는지 확인해본다.

1. MethodInliningDemo 를 실행해서 결과를 확인한다. (0ms 소요 확인)
2. VM Option `-XX:-Inline`으로 실행 (5ms 소요 확인)
3. VM Option `-XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining`으로 실행하여 setX, setY 메소드가 inline 됨을 확인 