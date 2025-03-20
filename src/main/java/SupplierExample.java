import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplierExample {
    public static void main(String[] args) {
        String mnemonic = createMnemonic();
        System.out.println(mnemonic);
    }

    private static String createMnemonic() {
        return Stream
                .generate(() -> getMnemonic())
                .limit(12)
                .collect(Collectors.joining(" "));
    }

    private static String getMnemonic() {
        List<String> mnemonic = Arrays.asList(
                "ShadowFox", "NeonWolf", "BlazeHunter", "SkyRider", "IronFist",
                "StormBreaker", "PhantomStriker", "NightHawk", "ThunderFury", "SolarFlare",
                "FrostByte", "VenomEdge", "GhostRogue", "CyberKnight", "RavenClaw",
                "StormChaser", "Firebrand", "SteelTitan", "WildFalcon", "DarkVortex",
                "LightningDash", "EchoPhantom", "MysticSaber", "ShadowDancer", "InfernoDrake",
                "LunarEclipse", "ZephyrWing", "ArcticBlaze", "TitanSlayer", "WarpSpeed"
        );
        Collections.shuffle(mnemonic);
        return mnemonic.get(0);
    }
}
