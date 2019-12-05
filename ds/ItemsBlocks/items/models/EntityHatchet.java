package coffee.can.ds.ItemsBlocks.items.models;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityHatchet extends EntityThrowable{

	public EntityHatchet(World world)
    {
        super(world);
    }

    public EntityHatchet(World world, EntityLivingBase liv)
    {
        super(world, liv);
    }

    public EntityHatchet(World world, double d1, double d2, double d3)
    {
        super(world, d1, d2, d3);
    }
	@Override
	protected void onImpact(MovingObjectPosition pos1) {
		if(pos1.entityHit != null) {
			
			pos1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (1.0f));
		}
	}

}
