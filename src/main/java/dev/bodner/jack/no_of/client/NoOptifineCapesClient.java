package dev.bodner.jack.no_of.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.optifine.http.HttpUtils;
import net.optifine.player.CapeUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.regex.Pattern;

@Environment(EnvType.CLIENT)
public class NoOptifineCapesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        //removes cape by setting the pattern for a valid username to not include any characters.
        try {
            Field field = CapeUtils.class.getDeclaredField("PATTERN_USERNAME");
            field.setAccessible(true);
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            field.set(null, Pattern.compile(""));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        //removes the extra accessories by setting the playerItemsUrl to a blank url
        try{
            Field field = HttpUtils.class.getDeclaredField("playerItemsUrl");
            field.setAccessible(true);
            field.set(null, "");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
