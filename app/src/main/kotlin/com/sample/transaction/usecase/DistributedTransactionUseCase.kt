package com.sample.transaction.usecase

import com.sample.transaction.core.domain.repository.DistributedTransactionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class DistributedTransactionUseCase(
    private val repository: DistributedTransactionRepository,
) {
    operator fun invoke() {
        repository.register()
    }
}
