# Job, Step, Tasklet

> Job > Step > Tasklet 순서로 실행

1. Configuration 설정: 하나의 배치 Job 을 정의하고 빈 설정
2. JobBuilderFactory: Job 을 생성하는 빌더 팩토리
3. StepBuilderFactory: Step 을 생성하는 빌더 팩토리
4. Job: Job 생성
5. Step: Step 생성
6. Tasklet: Step 안에서 단일 태스크로 수행되는 로직 구현
