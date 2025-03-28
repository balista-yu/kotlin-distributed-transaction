package com.sample.transaction.presentation.controller

import com.sample.transaction.usecase.DistributedTransactionUseCase
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("sample")
@CrossOrigin
class DistributedTransactionController(
    private val useCase: DistributedTransactionUseCase,
) {
    @GetMapping("/distributed-transaction")
    operator fun invoke() {
        useCase()
    }
}
