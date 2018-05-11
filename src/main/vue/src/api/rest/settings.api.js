import client from '@/api/rest/client';
/**
 * Returns user settings
 * @returns {UserSettings<settings>}
 */

export function getSettings() {
    return client.get(`/settings`);
}
export function setSettings(settings) {
    return client.post(`/settings`, settings);
}
