package io.github.blumbo.inventorymerger.saving;

import com.google.gson.JsonElement;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import net.minecraft.item.ItemStack;

public class SavableItemStack {
    JsonElement itemData;

    public SavableItemStack(ItemStack itemStack) {
        this.itemData = convertToJson(itemStack);
    }

    public JsonElement convertToJson(ItemStack itemStack) {
        DataResult<JsonElement> result = ItemStack.CODEC.encodeStart(JsonOps.INSTANCE, itemStack);

        return result.getOrThrow();
    }

    public ItemStack toItemStack() {
        DataResult<ItemStack> result = ItemStack.CODEC.parse(JsonOps.INSTANCE, this.itemData);

        return result.getOrThrow();
    }
}
