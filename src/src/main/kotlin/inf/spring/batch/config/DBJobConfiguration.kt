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
class DBJobConfiguration(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Bean
    fun helloJob(): Job {
        return jobBuilderFactory.get("helloJob")
            .start(dbStep1())
            .next(dbStep2())
            .build()
    }

    @Bean
    fun dbStep1(): Step {
        return stepBuilderFactory.get("helloStep1")
            .tasklet { contribution, chunkContext ->
                log.info("============  dbStep1 executed ============")
                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    fun dbStep2(): Step {
        return stepBuilderFactory.get("helloStep2")
            .tasklet { contribution, chunkContext ->
                log.info("============ dbStep2 executed ============")
                RepeatStatus.FINISHED
            }
            .build()
    }
}