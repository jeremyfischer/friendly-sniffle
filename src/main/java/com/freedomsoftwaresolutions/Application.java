package com.freedomsoftwaresolutions;

import com.freedomsoftwaresolutions.OutputDataService.Entities.InputData;
import com.freedomsoftwaresolutions.OutputDataService.Plugin.NullOutputDataStrategy;
import com.freedomsoftwaresolutions.OutputDataService.Plugin.OutputDataStrategy;
import com.freedomsoftwaresolutions.OutputDataService.OutputDataService;
import com.freedomsoftwaresolutions.OutputDataService.Plugin.IpOutputDataStrategy;
import com.freedomsoftwaresolutions.OutputDataService.Plugin.ZipOutputDataStrategy;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Application {

    public static void main(String[] args) {
        // Yucky, use dependency injection.
        final Map<Predicate<InputData>, OutputDataStrategy> chooser = new HashMap<>();
        chooser.put(ZipOutputDataStrategy::isValid, new ZipOutputDataStrategy());
        chooser.put(IpOutputDataStrategy::isValid, new IpOutputDataStrategy());
        chooser.put(NullOutputDataStrategy::isValid, new NullOutputDataStrategy());


        InetAddress google = null;
        try {
            google = InetAddress.getByName("www.google.com");
        } catch (Exception e) {
            System.out.println("Check your internet connectivity.");
            System.exit(-1);
        }

        final OutputDataService service = new OutputDataService(chooser);
        System.out.println(service.getOutputData(new InputData("55405", null)));
        System.out.println();
        System.out.println(service.getOutputData(new InputData(null, google)));
        System.out.println();
        System.out.println(service.getOutputData(new InputData(null, null)));
        System.out.println();
    }
}
