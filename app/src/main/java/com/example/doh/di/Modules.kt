package com.example.doh.di

import com.example.doh.viewmodels.HomeFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module


import org.koin.dsl.module

val viewModels = module {
    viewModel{HomeFragmentViewModel()}
}

val applicationModules:List<Module> = listOf(
    viewModels
)