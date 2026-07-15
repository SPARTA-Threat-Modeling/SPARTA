/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.analysis.util;

/**
 * Immutable RGB triple with the pure colour-interpolation math used by the
 * risk-coloured threat list. Kept free of any SWT/JFace dependency so the
 * interpolation and validity logic can be unit tested headlessly.
 *
 * @author Laurens
 */
public final class ColorTriple {

	private final int x;
	private final int y;
	private final int z;

	public ColorTriple() {
		this(0, 0, 0);
	}

	public ColorTriple(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	/**
	 * @return {@code true} when all three components are valid 8-bit colour
	 *         channels (0-255).
	 */
	public boolean validColor() {
		return (x >= 0 && x <= 255 && y >= 0 && y <= 255 && z >= 0 && z <= 255);
	}

	private static int inter(int a, int b, double pct) {
		return (int) (((1.0 - pct) * a) + (pct * b));
	}

	/**
	 * Linearly interpolates between two colours.
	 *
	 * @param t1  the colour at {@code pct == 0}
	 * @param t2  the colour at {@code pct == 1}
	 * @param pct the interpolation factor
	 * @return the interpolated colour
	 */
	public static ColorTriple interPol(ColorTriple t1, ColorTriple t2, double pct) {
		return new ColorTriple(inter(t1.getX(), t2.getX(), pct), inter(t1.getY(), t2.getY(), pct),
				inter(t1.getZ(), t2.getZ(), pct));
	}

	@Override
	public String toString() {
		return "ColorTriple(X:" + x + " Y:" + y + " Z:" + z + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		result = prime * result + z;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		ColorTriple other = (ColorTriple) obj;
		return x == other.x && y == other.y && z == other.z;
	}
}
