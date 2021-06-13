package glowsand.fishybears.mixin;

import glowsand.fishybears.PolarBearFishGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(PolarBearEntity.class)
public abstract class BearMixin extends AnimalEntity {
    protected BearMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method =  "initGoals",at = @At("TAIL"))
    public void initGoalMixin(CallbackInfo ci){
        this.goalSelector.add(5,new PolarBearFishGoal(((PolarBearEntity)(Object)this),1.0D,20));
    }
}
