export const WateringSchedule = {
  DAILY: 'DAILY',
  WEEKLY: 'WEEKLY',
  BIWEEKLY: 'BIWEEKLY',
  ASNEEDED: 'ASNEEDED',
} as const;
  
export type WateringSchedule = typeof WateringSchedule[keyof typeof WateringSchedule];

export interface Plant {
  id:number
  name: string;
  latinName: string;
  description: string;
  wateringSchedule: WateringSchedule;
  lastWatered: Date;
}
