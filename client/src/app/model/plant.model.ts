// plant.model.ts
export const WateringSchedule = {
  DAILY: 1,
  WEEKLY: 2,
  BIWEEKLY: 3,
  ASNEEDED: 4,
} as const;

export type WateringSchedule = typeof WateringSchedule[keyof typeof WateringSchedule];

export interface Plant {
  id:number
  name: string;
  latinName: string;
  description: string;
  wateringSchedule: WateringSchedule;
}
