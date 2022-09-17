package inf.spring.batch.config

import org.slf4j.LoggerFactory
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HelloJobConfiguration(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Bean
    fun helloJob(): Job {
        return jobBuilderFactory.get("helloJob")
            .start(helloStep1())
            .next(helloStep2())
            .build()
    }

    @Bean
    fun helloStep1(): Step {
        return stepBuilderFactory.get("helloStep1")
            .tasklet { contribution, chunkContext ->
                log.info("============  helloStep1 executed ============")
                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    fun helloStep2(): Step {
        return stepBuilderFactory.get("helloStep2")
            .tasklet { contribution, chunkContext ->
                log.info("============ helloStep2 executed ============")
                RepeatStatus.FINISHED
            }
            .build()
    }
}