package utils;

public class Converter {
    public static GUIAction getAction(String actionCommand) {
        GUIAction guiAction = GUIAction.INITIAL_STATE;
        String guiActionStr = actionCommand.toUpperCase().replace(" ", "_");
        try {
            if (GUIAction.class.getField(guiActionStr) != null) {
                guiAction = GUIAction.valueOf(guiActionStr);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return guiAction;
    }
}
