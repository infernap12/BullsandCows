package bullscows;

import java.lang.management.ManagementFactory;
import java.util.List;

public class ModeDetector {
    public static String detectMode() {
        List<String> jvmArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();

        // Check for unique indicators in JVM arguments
        for (String arg : jvmArguments) {
            if (arg.contains("-agentlib:jdwp")) {
                return "Debug";
            }
            if (arg.contains("idea_rt.jar")) {
                return "Normal";
            }
            if (arg.contains("org.gradle.internal.worker.tmpdir") || arg.contains("-ea")) {
                return "Check";
            }
        }

        return "Unknown"; // Default case
    }
}
