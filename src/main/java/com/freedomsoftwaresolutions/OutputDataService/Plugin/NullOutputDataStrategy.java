package com.freedomsoftwaresolutions.OutputDataService.Plugin;

import com.freedomsoftwaresolutions.OutputDataService.Entities.InputData;
import com.freedomsoftwaresolutions.OutputDataService.Entities.OutputData;

public class NullOutputDataStrategy implements OutputDataStrategy {
    @Override
    public OutputData getOutputData(InputData inputData) {
        return new OutputData("No city found");
    }

    public static boolean isValid(final InputData inputData) {
        return true;
    }
}
