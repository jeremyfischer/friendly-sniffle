package com.freedomsoftwaresolutions.OutputDataService.Internal;

import com.freedomsoftwaresolutions.OutputDataService.Entities.InputData;
import com.freedomsoftwaresolutions.OutputDataService.Plugin.NullOutputDataStrategy;
import com.freedomsoftwaresolutions.OutputDataService.Plugin.OutputDataStrategy;

import java.util.Map;
import java.util.function.Predicate;

public class OutputDataStrategyBuilder {

    private final Map<Predicate<InputData>, OutputDataStrategy> chooser;

    public OutputDataStrategyBuilder(final Map<Predicate<InputData>, OutputDataStrategy> chooser) {
        this.chooser = chooser;
    }

    public final OutputDataStrategy build(final InputData inputData) {
        return chooser.entrySet()
                .stream()
                .filter(x -> x.getKey().test(inputData))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(new NullOutputDataStrategy());
    }
}
