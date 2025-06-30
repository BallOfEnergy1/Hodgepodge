package com.mitchej123.hodgepodge;

import com.mitchej123.hodgepodge.config.FixesConfig;
import com.mitchej123.hodgepodge.config.TweaksConfig;

public class SpoolCompat {

	public static boolean addSimulationDistance;
	public static int simulationDistance;

	public static void init() {
		addSimulationDistance = FixesConfig.addSimulationDistance;
		simulationDistance = TweaksConfig.simulationDistance;
	}
}
