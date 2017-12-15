package com.freedomsoftwaresolutions.OutputDataService;

import com.freedomsoftwaresolutions.OutputDataService.Entities.InputData;
import com.freedomsoftwaresolutions.OutputDataService.Entities.OutputData;
import com.freedomsoftwaresolutions.OutputDataService.Plugin.OutputDataStrategy;
import com.freedomsoftwaresolutions.OutputDataService.Internal.OutputDataStrategyBuilder;

import java.util.Map;
import java.util.function.Predicate;

public final class OutputDataService {

    private final OutputDataStrategyBuilder builder;

    public OutputDataService(final Map<Predicate<InputData>, OutputDataStrategy> chooser) {
        this.builder = new OutputDataStrategyBuilder(chooser);
    }

    public final OutputData getOutputData(final InputData inputData) {
        final OutputDataStrategy outputDataStrategy = builder.build(inputData);
        return outputDataStrategy.getOutputData(inputData);
    }
}
