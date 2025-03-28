package com.sample.transaction.presentation.controller

import com.sample.transaction.usecase.FailedDistributedTransactionUseCase
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("sample")
@CrossOrigin
class FailedDistributedTransactionController(
    private val useCase: FailedDistributedTransactionUseCase,
) {
    @GetMapping("/failed-distributed-transaction")
    operator fun invoke() {
        useCase()
    }
}
