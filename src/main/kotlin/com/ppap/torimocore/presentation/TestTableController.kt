package com.ppap.torimocore.presentation

import com.ppap.torimocore.domain.TestTable.TestTable
import com.ppap.torimocore.usecase.TestTableUsecase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/testTables")
class TestTableController(private val testTableUsecase: TestTableUsecase) {

    @GetMapping("list")
    fun index(): List<TestTable> = testTableUsecase.findAll()

    @GetMapping("{id}")
    fun show(@PathVariable("id") id: Long): TestTable = testTableUsecase.findOne(id)
}
