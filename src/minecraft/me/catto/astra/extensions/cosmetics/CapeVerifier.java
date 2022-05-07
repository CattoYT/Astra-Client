package me.catto.astra.extensions.cosmetics;

import net.minecraft.client.entity.AbstractClientPlayer;

public class CapeVerifier {

    public static boolean ownsCape(AbstractClientPlayer entitylivnbaseIn) {
        if (entitylivnbaseIn.getName().equals("Hikari_Ayana") || entitylivnbaseIn.getName().equals("IUseRusherhack")) {
            return true;
        }
        else {
            return false;
        }
    }
}
