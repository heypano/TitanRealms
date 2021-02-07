package sylvantus.titanrealms.core.network.container.property;

import net.minecraft.network.PacketBuffer;
import sylvantus.titanrealms.common.containers.tiles.TitanRealmsContainer;

public class BytePropertyData extends PropertyData {

    private final byte value;

    public BytePropertyData(short property, byte value) {
        super(PropertyType.BYTE, property);
        this.value = value;
    }

    @Override
    public void handleWindowProperty(TitanRealmsContainer container) {
        container.handleWindowProperty(getProperty(), value);
    }

    @Override
    public void writeToPacket(PacketBuffer buffer) {
        super.writeToPacket(buffer);
        buffer.writeByte(value);
    }
}