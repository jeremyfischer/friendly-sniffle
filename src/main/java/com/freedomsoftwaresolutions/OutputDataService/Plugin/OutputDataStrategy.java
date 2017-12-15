package com.freedomsoftwaresolutions.OutputDataService.Plugin;

import com.freedomsoftwaresolutions.OutputDataService.Entities.InputData;
import com.freedomsoftwaresolutions.OutputDataService.Entities.OutputData;

public interface OutputDataStrategy {
    OutputData getOutputData(InputData inputData);
}
