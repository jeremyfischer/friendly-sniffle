package com.freedomsoftwaresolutions.OutputDataService.Plugin;

import com.freedomsoftwaresolutions.OutputDataService.Entities.InputData;
import com.freedomsoftwaresolutions.OutputDataService.Entities.OutputData;

import java.util.Optional;

public class IpOutputDataStrategy implements OutputDataStrategy {
    @Override
    public OutputData getOutputData(InputData inputData) {
        return new OutputData("Plymouth");
    }

    public static boolean isValid(final InputData inputData) {
        return Optional.ofNullable(inputData)
                .map(InputData::getIp)
                .isPresent();
    }
}
