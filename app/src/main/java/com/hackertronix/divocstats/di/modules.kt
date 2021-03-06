package com.hackertronix.divocstats.di

import com.hackertronix.data.repository.CountryStatsRepository
import com.hackertronix.divocstats.countrystats.CountryStatsAdapter
import com.hackertronix.divocstats.countrystats.CountryStatsViewModel
import com.hackertronix.divocstats.countrystats.india.IndiaStatsViewModel
import com.hackertronix.divocstats.overview.OverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        OverviewViewModel(get())
    }

    viewModel {
        CountryStatsViewModel(get<CountryStatsRepository>())
    }
    viewModel {
        IndiaStatsViewModel(get())
    }
}

val adaptersModule = module {
    factory {
        CountryStatsAdapter()
    }
}