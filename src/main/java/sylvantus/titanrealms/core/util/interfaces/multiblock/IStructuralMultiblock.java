package sylvantus.titanrealms.core.util.interfaces.multiblock;

import sylvantus.titanrealms.core.lib.multiblock.MultiblockManager;
import sylvantus.titanrealms.core.lib.multiblock.Structure;

import java.util.Map;

public interface IStructuralMultiblock extends IMultiblockBase {

    boolean canInterface(MultiblockManager<?> manager);

    Map<MultiblockManager<?>, Structure> getStructureMap();

    boolean hasFormedMultiblock();

    /**
     * Returns true if the multiblock's gui can be accessed via structural multiblocks, false otherwise. An example this may be false for would be on a thermal
     * evaporation plant.
     */
    boolean structuralGuiAccessAllowed();
}