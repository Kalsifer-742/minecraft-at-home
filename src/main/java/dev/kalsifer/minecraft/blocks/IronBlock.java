package dev.kalsifer.minecraft.blocks;

import dev.kalsifer.minecraft.blocks.interfaces.IronBlockInterface;

class IronBlock extends AbstractSolidBlock implements IronBlockInterface {
    public IronBlock() {
        super();
        this.blockName = "Iron Block";
        this.content = 'i';
    }
}
