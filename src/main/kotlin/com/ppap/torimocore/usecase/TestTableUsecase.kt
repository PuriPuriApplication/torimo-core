package com.ppap.torimocore.usecase

import com.ppap.torimocore.domain.TestTable.TestTableRepository
import org.springframework.stereotype.Service

@Service
class TestTableUsecase(private val testTableRepository: TestTableRepository) {
    fun findAll() = testTableRepository.findAll()

    fun findOne(id: Long) = testTableRepository.findById(id).orElse(null)
}
