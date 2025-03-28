package com.sample.transaction.presentation.controller

import com.sample.transaction.usecase.FailedNotDistributedTransactionUseCase
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("sample")
@CrossOrigin
class FailedNotDistributedTransactionController(
    private val useCase: FailedNotDistributedTransactionUseCase,
) {
    @GetMapping("/failed-not-distributed-transaction")
    operator fun invoke() {
        useCase()
    }
}
