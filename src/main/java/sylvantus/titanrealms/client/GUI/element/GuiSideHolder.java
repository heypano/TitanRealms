package sylvantus.titanrealms.client.GUI.element;

import com.mojang.blaze3d.matrix.MatrixStack;
import javax.annotation.Nonnull;
import net.minecraft.util.ResourceLocation;
import sylvantus.titanrealms.core.util.interfaces.client.IGuiWrapper;
import sylvantus.titanrealms.client.render.TitanRealmsRenderer;
import sylvantus.titanrealms.client.render.lib.ColorAtlas.ColorRegistryObject;
import sylvantus.titanrealms.core.util.TitanRealmsUtils;
import sylvantus.titanrealms.core.util.TitanRealmsUtils.ResourceType;

public abstract class GuiSideHolder extends GuiTexturedElement {

    public static GuiSideHolder create(IGuiWrapper gui, int x, int y, int height, boolean left, ColorRegistryObject tabColor) {
        return new GuiSideHolder(gui, x, y, height, left) {
            @Override
            protected void colorTab() {
                TitanRealmsRenderer.color(tabColor);
            }
        };
    }

    private static final ResourceLocation HOLDER_LEFT = TitanRealmsUtils.getResource(ResourceType.GUI, "holder_left.png");
    private static final ResourceLocation HOLDER_RIGHT = TitanRealmsUtils.getResource(ResourceType.GUI, "holder_right.png");
    private static final int TEXTURE_WIDTH = 26;
    private static final int TEXTURE_HEIGHT = 9;

    protected final boolean left;

    protected GuiSideHolder(IGuiWrapper gui, int x, int y, int height, boolean left) {
        super(left ? HOLDER_LEFT : HOLDER_RIGHT, gui, x, y, TEXTURE_WIDTH, height);
        this.left = left;
        active = false;
        setButtonBackground(ButtonBackground.DEFAULT);
    }

    protected abstract void colorTab();

    @Override
    public void drawBackground(@Nonnull MatrixStack matrix, int mouseX, int mouseY, float partialTicks) {
        super.drawBackground(matrix, mouseX, mouseY, partialTicks);
        minecraft.textureManager.bindTexture(getResource());
        colorTab();
        //Top
        blit(matrix, x, y, 0, 0, width, 4, TEXTURE_WIDTH, TEXTURE_HEIGHT);
        //Middle
        int middleHeight = height - 8;
        if (middleHeight > 0) {
            blit(matrix, x, y + 4, width, middleHeight, 0, 4, width, 1, TEXTURE_WIDTH, TEXTURE_HEIGHT);
        }
        //Bottom
        blit(matrix, x, y + 4 + middleHeight, 0, 5, width, 4, TEXTURE_WIDTH, TEXTURE_HEIGHT);
        TitanRealmsRenderer.resetColor();
    }
}